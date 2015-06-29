package javayou;

import java.io.IOException;
import java.lang.annotation.Annotation;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

/**
 * text/plainなレスポンスにcharset=UTF-8を付けるフィルター
 *
 */
@Provider
@ApplicationScoped
public class CharsetFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext,
            ContainerResponseContext responseContext) throws IOException {

        if (responseContext.getMediaType().isCompatible(
                MediaType.TEXT_PLAIN_TYPE)) {

            Object entity = responseContext.getEntity();
            Annotation[] annotations = responseContext.getEntityAnnotations();
            MediaType mediaType = MediaType.TEXT_PLAIN_TYPE
                    .withCharset("UTF-8");

            responseContext.setEntity(entity, annotations, mediaType);
        }
    }
}
