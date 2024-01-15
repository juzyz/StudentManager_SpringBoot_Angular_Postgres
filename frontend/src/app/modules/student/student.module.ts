import { Component, NgModule } from '@angular/core';
import {CommonModule} from '@angular/common';
 import{HttpClientModule} from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router';
import { StudentComponent } from './student-component/student.component';
import { AuthGuard } from '../../authentication/guards/authGard/auth.guard';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatButtonModule} from '@angular/material/button';
import {MatInputModule} from '@angular/material/input';
import {MatNativeDateModule} from '@angular/material/core';


const routers: Routes = [
  {path: "dashboard", component: StudentComponent, canActivate:[AuthGuard]}
];

@NgModule({
  declarations: [
    StudentComponent
  ],
  imports: [
    CommonModule,
    HttpClientModule,
    MatFormFieldModule,
    MatInputModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatButtonModule
  ],
  exports: [RouterModule, StudentComponent]
})
export class StudentModule { }
