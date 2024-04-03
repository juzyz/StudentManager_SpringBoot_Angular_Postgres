import { Component } from '@angular/core';
import { AuthService } from '../../../authentication/service/auth/auth.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { response } from 'express';
import { StorageService } from '../../../authentication/storage/storage.service';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {

  loginForm: FormGroup | undefined; 

  constructor(
    private service: AuthService,
    private fb: FormBuilder,
    private router: Router,
    private snackbar: MatSnackBar
  ) { }

  ngOnInit() {
    this.loginForm = this.fb.group({
      email: ['', Validators.required],
      password: ['', Validators.required]
    })
  }

  login() {
    this.service.login(
      this.loginForm.get('email')!.value,
      this.loginForm.get('password')!.value
    ).subscribe((response) => {
      console.log(response);
      if (StorageService.isUserLoggedIn){
        this.router.navigateByUrl("student-list");
      }     
    }),
    error => {
      if (error.status == 406){
        this.snackbar.open("User is not active", "Close",
        {duration: 5000});
      } else {
        this.snackbar.open("Bad credentials", "Close",
        {duration: 5000});
      }
    }
  }
}
