/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.socialpatch.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

/**
 * REST Web Service
 *
 * @author sprucewerk
 */
@Path("commentingserviceport")
public class CommentingServicePort {
    private org.socialpatch.api_client.CommentingService port;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CommentingServicePort
     */
    public CommentingServicePort() {
        port = getPort();
    }

    /**
     * Invokes the SOAP method addComment
     * @param arg0 resource URI parameter
     * @param arg1 resource URI parameter
     */
    @PUT
    @Consumes("application/xml")
    @Path("addcomment/")
    public void putAddComment(String arg0, JAXBElement<org.socialpatch.api_client.Comment> arg1) {
        try {
            // Call Web Service Operation
            if (port != null) {
                port.addComment(arg0, arg1.getValue());
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
    }

    /**
     * Invokes the SOAP method updateComment
     * @param arg0 resource URI parameter
     */
    @PUT
    @Consumes("application/xml")
    @Path("updatecomment/")
    public void putUpdateComment(JAXBElement<org.socialpatch.api_client.Comment> arg0) {
        try {
            // Call Web Service Operation
            if (port != null) {
                port.updateComment(arg0.getValue());
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
    }

    /**
     * Invokes the SOAP method commentTest
     */
    @PUT
    @Consumes("text/plain")
    @Path("commenttest/")
    public void putCommentTest() {
        try {
            // Call Web Service Operation
            if (port != null) {
                port.commentTest();
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
    }

    /**
     * Invokes the SOAP method removeCommentById
     * @param arg0 resource URI parameter
     */
    @PUT
    @Consumes("application/xml")
    @Path("removecommentbyid/")
    public void putRemoveCommentById(JAXBElement<Long> arg0) {
        try {
            // Call Web Service Operation
            if (port != null) {
                port.removeCommentById(arg0.getValue());
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
    }

    /**
     * Invokes the SOAP method getCommentsByUri
     * @param arg0 resource URI parameter
     * @return an instance of javax.xml.bind.JAXBElement<org.socialpatch.api_client.GetCommentsByUriResponse>
     */
    @GET
    @Produces("application/xml")
    @Consumes("text/plain")
    @Path("getcommentsbyuri/")
    public JAXBElement<org.socialpatch.api_client.GetCommentsByUriResponse> getCommentsByUri(@QueryParam("arg0") String arg0) {
        try {
            // Call Web Service Operation
            if (port != null) {
                java.util.List<org.socialpatch.api_client.Comment> result = port.getCommentsByUri(arg0);

                class GetCommentsByUriResponse_1 extends org.socialpatch.api_client.GetCommentsByUriResponse {

                    GetCommentsByUriResponse_1(java.util.List<org.socialpatch.api_client.Comment> _return) {
                        this._return = _return;
                    }
                }
                org.socialpatch.api_client.GetCommentsByUriResponse response = new GetCommentsByUriResponse_1(result);
                return new org.socialpatch.api_client.ObjectFactory().createGetCommentsByUriResponse(response);
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     *
     */
    private org.socialpatch.api_client.CommentingService getPort() {
        try {
            // Call Web Service Operation
            org.socialpatch.api_client.CommentingService_Service service = new org.socialpatch.api_client.CommentingService_Service();
            org.socialpatch.api_client.CommentingService p = service.getCommentingServicePort();
            return p;
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }
}
