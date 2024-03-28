import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './modules/login/login-component/login.component';
import { StudentComponent } from './modules/student/student-component/student.component';
import { NoAuthGuard } from './authentication/guards/noAuthGard/no-auth.guard';

const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: "login", component: LoginComponent, canActivate: [NoAuthGuard] },
  { path: "student", component: StudentComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
