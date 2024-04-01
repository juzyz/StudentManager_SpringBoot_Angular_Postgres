import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http'
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './modules/login/login-component/login.component';
import {MatInputModule} from '@angular/material/input';
import { MatToolbarModule } from '@angular/material/toolbar';
import {MatButtonModule} from '@angular/material/button';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { StudentComponent } from './modules/student/student-component/student.component';
import {MatSnackBarModule} from '@angular/material/snack-bar';

import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MAT_DATE_LOCALE, MatNativeDateModule} from '@angular/material/core';
import {MatCardModule} from '@angular/material/card';
import { MatTableModule } from '@angular/material/table' ;
import { MatIconModule } from '@angular/material/icon';
import { AuthGuard } from './authentication/guards/authGard/auth.guard';
// import { CommonModule } from '@angular/common';
import { StudentListComponent } from './modules/student/student-list/student-list.component';
import { CreateStudentComponent } from './modules/student/create-student/create-student.component';
import { UpdateStudentComponent } from './modules/student/update-student/update-student.component';
import { AttendanceReportComponent } from './modules/reports/attendance-report/attendance-report.component';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    StudentComponent,
    StudentListComponent,
    CreateStudentComponent,
    UpdateStudentComponent,
    AttendanceReportComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    MatInputModule,
    FormsModule,
    ReactiveFormsModule,
    MatToolbarModule,
    MatButtonModule,
    MatSlideToggleModule,
    BrowserAnimationsModule,
    MatSnackBarModule,
    MatDatepickerModule,
    MatFormFieldModule,
    MatNativeDateModule,
    MatProgressSpinnerModule,
    MatCardModule,
    MatTableModule,
    MatIconModule,
    // CommonModule
  ],
  providers: [
    provideClientHydration(),
    AuthGuard
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
