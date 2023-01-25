package app.xquare.dms.global.error;

import app.xquare.dms.global.error.exception.GlobalException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RequiredArgsConstructor
public class GlobalErrorFilter extends OncePerRequestFilter {

    private final ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (GlobalException e) {
            setErrorResponse(e.getExceptionProperty(), response);
        } catch (Exception e) {
            if (e.getCause() instanceof GlobalException globalException) {
                setErrorResponse(globalException.getExceptionProperty(), response);
            } else {
                e.printStackTrace();
                setErrorResponse(GlobalErrorCode.INTERNAL_SERVER_ERROR, response);
            }
        }
    }

    private void setErrorResponse(ExceptionProperty errorProperty, HttpServletResponse response) throws IOException {
        response.setStatus(errorProperty.getStatus());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.getWriter().write(
                objectMapper.writeValueAsString(
                        new ErrorResponse(errorProperty)
                )
        );
    }
}
