package org.babcock

import grails.converters.*
import org.codehaus.groovy.grails.web.converters.exceptions.ConverterException
import com.restfb.*




class BookController {

    
    def list  = {
        println("inlist")
        println("params:" +  params)

        if(params["code"] == null){
            render("<script>top.location.href='https://www.facebook.com/dialog/oauth?client_id=260808250614521&redirect_uri=https://apps.facebook.com/testnewsstories/'</script>")
        }


        String signed_request = ""
        if(params.containsKey('signed_request')){
            signed_request = params.signed_request.split("\\.")[1]
            //split on dot
        }
                
        def json = null
        try{
            json = JSON.parse(new String(signed_request.decodeBase64()))

        }
        catch( ConverterException e ){
            log.error("could not parse signed_request json")
            log.error("signed_request:$signed_request")
            render("required signed_request param not found")
            return
        }
        session.originalSignedRequestObject = json
        //        redirect(url: "https://www.facebook.com/dialog/oauth", params:[client_id:"260808250614521", redirect_uri: "http://localhost:8080/book/show"])
        println(json.toString())
    }


    def show = {
        println("holla biatch")
        render("holla biatch")
    }
}






