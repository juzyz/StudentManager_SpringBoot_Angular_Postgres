import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { StorageService } from '../../../authentication/storage/storage.service';

const BASIC_URL = ["http://localhost:8080"];

@Injectable({
  providedIn: 'root'
})

export class StudentService {

  constructor(private http: HttpClient) { }

  getAllStudents() {
    let test = this.createAuthorizationHeader();
    let dfg = 13;
    return this.http.get<[]>(BASIC_URL + "/api/v1/student", {
      headers: this.createAuthorizationHeader(),
      observe: 'response'
    });
  }

  addStudent(student: any) {
    let test = this.createAuthorizationHeader();
    let dfg = 13;
    return this.http.post<[]>(BASIC_URL + "/api/v1/student", student, {
      headers: this.createAuthorizationHeader(),
      observe: 'response'
    });
  }

  deleteStudent(studentId: any) {
    let test = this.createAuthorizationHeader();
    let dfg = 13;
    return this.http.delete<[]>(BASIC_URL + "/api/v1/student/" + studentId, {
      headers: this.createAuthorizationHeader(),
      observe: 'response'
    });
  }

  updateStudent(studentId: string): (error: any) => void {
    throw new Error('Method not implemented.');
  }

  private createAuthorizationHeader(): HttpHeaders {
    return new HttpHeaders()
      .set('Content-Type', 'application/json')
      .set('Authorization', 'Bearer ' + StorageService.getToken());
  }
}
