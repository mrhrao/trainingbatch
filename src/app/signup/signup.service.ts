import { Injectable } from '@angular/core';
import { ResourceService } from "./../shared/resource.component";

@Injectable()
export class SignUpService {
   // public loginUrl = URLS.loginUrl;
   
    constructor(public resourceService: ResourceService) {

    }

    submitLogin(data) {
        let url = 'http://192.168.9.167:8080/sign_up';
        return this.resourceService.sendPostRequest(data, url).then(response => {
            return response;
        }).catch((err) => {
        });
    }
}