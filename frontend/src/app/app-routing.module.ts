import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './modules/login/login-component/login.component';
import { StudentComponent } from './modules/student/student-component/student.component';
import { NoAuthGuard } from './authentication/guards/noAuthGard/no-auth.guard';
import { StudentListComponent } from './modules/student/student-list/student-list.component';
import { CreateStudentComponent } from './modules/student/create-student/create-student.component';
import { UpdateStudentComponent } from './modules/student/update-student/update-student.component';
import { AttendanceReportComponent } from './modules/reports/attendance-report/attendance-report.component';


const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  // { path: '', redirectTo: 'students', pathMatch: 'full' },
  { path: "login", component: LoginComponent, canActivate: [NoAuthGuard] },
  { path: "student-list", component: StudentListComponent },
  { path: "create-student", component: CreateStudentComponent },
  { path: "update-student/:id", component: UpdateStudentComponent },
  { path: "report", component: AttendanceReportComponent },
  { path: "student", component: StudentComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
