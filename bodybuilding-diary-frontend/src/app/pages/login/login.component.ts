import { Component } from '@angular/core';
import { AuthenticationRequest } from '../../models/authentication-request';
import { InputTextModule } from 'primeng/inputtext';
import { FormsModule } from '@angular/forms';
import { FloatLabelModule } from 'primeng/floatlabel';
import { ButtonModule } from 'primeng/button';
import { Router } from '@angular/router';
import { AuthenticationService } from '../../services/authentication.service';
import { NgFor, NgIf } from '@angular/common';
import { TokenService } from '../../services/token.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, InputTextModule, NgIf, NgFor, FloatLabelModule, ButtonModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {

  authRequest: AuthenticationRequest = { email: '', password: ''};
  errorMsg: Array<string> = [];

  constructor(
    private router: Router,
    private authService: AuthenticationService,
    private tokenService: TokenService
  ) {}

  login() {
    this.authService.authenticate(this.authRequest).subscribe({
      next: (response) => {
        this.tokenService.token = response.token;
      },
      error: (response) => {
        console.log(response);
        if (response.error.validationErrors) {
          this.errorMsg = response.error.validationErrors;
        } else {
          this.errorMsg.push(response.error.errorMsg);
        }
      }
    });
  }

  register() {
    this.router.navigate(['register']);
  }
}
