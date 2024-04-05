import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { StorageService } from '../../../authentication/storage/storage.service';
import { Student } from '../student';

const BASIC_URL = ["http://localhost:8080"];

@Injectable({
  providedIn: 'root'
})

export class StudentService {

  constructor(private http: HttpClient) { }

  getAllStudents() {
    return this.http.get<[]>(BASIC_URL + "/api/v1/student", {
      headers: this.createAuthorizationHeader(),
      observe: 'response'
    });
  }

  getStudentById(studentId: number) {
    return this.http.get<Student>(BASIC_URL + "/api/v1/student/" + studentId, {
      headers: this.createAuthorizationHeader(),
      observe: 'response'
    });
  }

  addStudent(student: any) {
    return this.http.post<[]>(BASIC_URL + "/api/v1/student", student, {
      headers: this.createAuthorizationHeader(),
      observe: 'response'
    });
  }

  deleteStudent(studentId: any) {
    return this.http.delete<[]>(BASIC_URL + "/api/v1/student/" + studentId, {
      headers: this.createAuthorizationHeader(),
      observe: 'response'
    });
  }

  updateStudent(student: any){
    return this.http.put<[]>(BASIC_URL + "/api/v1/student", student, {
      headers: this.createAuthorizationHeader(),
      observe: 'response'
    });
  }

  private createAuthorizationHeader(): HttpHeaders {
    return new HttpHeaders()
      .set('Content-Type', 'application/json')
      .set('Authorization', 'Bearer ' + StorageService.getToken());
  }
}
