package com.javiermoreno.rest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 *
 * @author ciberado
 */
@WebFilter(filterName = "JsonpFilter", urlPatterns = {"/api/*"}, dispatcherTypes = {DispatcherType.FORWARD, DispatcherType.REQUEST})
public class JsonpFilter implements Filter {

    
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        String callbackValue = request.getParameter("callback");
        if (callbackValue != null) {
            ResponseWrapper wrappedResponse
                    = new ResponseWrapper((HttpServletResponse) response);
            chain.doFilter(request, wrappedResponse);
            byte[] prefix = (callbackValue + "(").getBytes("utf8");
            byte[] content = wrappedResponse.getContentAsBytes();
            byte[] sufix = (")").getBytes("utf8");
            int length = prefix.length + content.length + sufix.length;
            
            wrappedResponse.setHeader("Content-Length", String.valueOf(length));
            OutputStream realOut = response.getOutputStream();
            realOut.write(prefix);
            realOut.write(content);
            realOut.write(sufix);
        } else {
            chain.doFilter(request, response);
        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
    

    class FakeServletOutputStream extends ServletOutputStream {

        private ByteArrayOutputStream out;

        public FakeServletOutputStream() {
            out = new ByteArrayOutputStream(1024 * 32);
        }

        public ByteArrayOutputStream getImplementation() {
            return out;
        }
        
        @Override
        public void close() throws IOException {
            out.close();
        }

        @Override
        public void flush() throws IOException {
            out.flush();
        }

        @Override
        public void write(int data) throws IOException {
            out.write((byte) data);
        }

        @Override
        public void write(byte data[]) throws IOException {
            write(data, 0, data.length);
        }

        @Override
        public void write(byte data[], int off, int len) throws IOException {
            out.write(data, off, len);
        }

    }

    class ResponseWrapper extends HttpServletResponseWrapper {

        private FakeServletOutputStream out;

        public ResponseWrapper(HttpServletResponse response) {
            super(response);
            out = new FakeServletOutputStream();
        }

        @Override
        public ServletOutputStream getOutputStream() throws IOException {
            return out;
        }

        public byte[] getContentAsBytes() {
            return out.getImplementation().toByteArray();
        }
    }

}
