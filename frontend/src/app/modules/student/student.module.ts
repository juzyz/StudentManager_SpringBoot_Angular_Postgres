import { Component, NgModule } from '@angular/core';
import {CommonModule} from '@angular/common';
 import{HttpClientModule} from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router';
import { StudentComponent } from './student-component/student.component';
// import { AuthGuard } from '../../authentication/guards/authGard/auth.guard';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatButtonModule} from '@angular/material/button';
import {MatInputModule} from '@angular/material/input';
import {MatNativeDateModule} from '@angular/material/core';
import { MatTableModule } from '@angular/material/table' ;
import { MatIconModule } from '@angular/material/icon';

const routers: Routes = [
    {path: "dashboard", component: StudentComponent}//, canActivate:[AuthGuard]}
];

@NgModule({
  imports: [
    CommonModule,
    HttpClientModule,
    MatFormFieldModule,
    MatInputModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatButtonModule,
    MatTableModule,
    MatIconModule


  ],
  exports: [RouterModule ],
  declarations: [
    // StudentListComponent
    // StudentPanelComponent
    // CreateStudentComponent
    // UpdateStudentComponent
  ]
})
export class StudentModule { }
