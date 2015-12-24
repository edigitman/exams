package ro.ghasachi.bt.web.controller;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ro.ghasachi.bt.web.util.LinkUtil;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriTemplate;

@Controller
@RequestMapping(value = "/root")
public class RootController {

    public RootController() {
        super();
    }

    // API

    // discover

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void adminRoot(final HttpServletRequest request, final HttpServletResponse response) {
        final String rootUri = request.getRequestURL().toString();

        final URI fooUri = new UriTemplate("{rootUri}/{resource}").expand(rootUri, "foo");
        final String linkToFoo = LinkUtil.createLinkHeader(fooUri.toASCIIString(), "collection");

        // ADMIN URI
        
        final URI adminUri = new UriTemplate("{rootUri}/{resource}").expand(rootUri, "admin");
        final String linkToAdmin = LinkUtil.createLinkHeader(adminUri.toASCIIString(), "admin resource");
        
        // PROF URI
        
        final URI profExamUri = new UriTemplate("{rootUri}/{resource}").expand(rootUri, "prof/exam");
        final String linkToProfExam = LinkUtil.createLinkHeader(profExamUri.toASCIIString(), "prof exam crud");
        
        final URI profExamInstUri = new UriTemplate("{rootUri}/{resource}").expand(rootUri, "prof/examInstance");
        final String linkToProfExamInst = LinkUtil.createLinkHeader(profExamInstUri.toASCIIString(), "prof exam instance crud");
        
        final URI profExamItemUri = new UriTemplate("{rootUri}/{resource}").expand(rootUri, "prof/examItem");
        final String linkToProfExamItem = LinkUtil.createLinkHeader(profExamItemUri.toASCIIString(), "prof exam item crud");
        
        final URI profExamGroupUri = new UriTemplate("{rootUri}/{resource}").expand(rootUri, "prof/examGroup");
        final String linkToProfExamGroup = LinkUtil.createLinkHeader(profExamGroupUri.toASCIIString(), "prof exam group crud");
        
        final URI profExamItemAnswUri = new UriTemplate("{rootUri}/{resource}").expand(rootUri, "prof/examItemAnswer");
        final String linkToProfExamItemAnsw = LinkUtil.createLinkHeader(profExamItemAnswUri.toASCIIString(), "prof exam item answer crud");
        
        // STUD URI
        
        final URI studExamUri = new UriTemplate("{rootUri}/{resource}").expand(rootUri, "stud/exam");
        final String linkToStudExam = LinkUtil.createLinkHeader(studExamUri.toASCIIString(), "stud exam crud");
        
        final URI studItemUri = new UriTemplate("{rootUri}/{resource}").expand(rootUri, "stud/item");
        final String linkToStudItem = LinkUtil.createLinkHeader(studItemUri.toASCIIString(), "stud item crud");
        
        // USER URI
        
        final URI userTokenUri = new UriTemplate("{rootUri}/{resource}").expand(rootUri, "user/t/{token}");
        final String linkToUserToken = LinkUtil.createLinkHeader(userTokenUri.toASCIIString(), "get user by token");
        
        final URI userPassUri = new UriTemplate("{rootUri}/{resource}").expand(rootUri, "user/pass");
        final String linkToUserPass = LinkUtil.createLinkHeader(userPassUri.toASCIIString(), "post user password");
        
        response.addHeader("Link", linkToFoo);
        
        response.addHeader("Link", linkToAdmin);
        
        response.addHeader("Link", linkToProfExam);
        response.addHeader("Link", linkToProfExamInst);
        response.addHeader("Link", linkToProfExamItem);
        response.addHeader("Link", linkToProfExamGroup);
        response.addHeader("Link", linkToProfExamItemAnsw);
        
        response.addHeader("Link", linkToStudExam);
        response.addHeader("Link", linkToStudItem);
        
        response.addHeader("Link", linkToUserToken);
        response.addHeader("Link", linkToUserPass);
        
    }

}
