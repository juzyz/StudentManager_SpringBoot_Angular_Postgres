import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './modules/login/login-component/login.component';
import { StudentComponent } from './modules/student/student-component/student.component';
import { noAuthGuard } from './authentication/guards/noAuthGard/no-auth.guard';

const routes: Routes = [
  { path: "login", component: LoginComponent, canActivate: [noAuthGuard] },
  { path: "student", component: StudentComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
