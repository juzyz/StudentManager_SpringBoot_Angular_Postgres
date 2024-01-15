import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { StudentService } from '../student-service/student.service';
import { MatSnackBar } from '@angular/material/snack-bar';


@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrl: './student.component.scss'
})

export class StudentComponent {


  validateForm: FormGroup;
  students: any[];

  constructor(
    private service: StudentService,
    private fb: FormBuilder,
    private snackBar: MatSnackBar
  ) {}

  ngOnInit(): void {
    this.validateForm = this.fb.group({
      email: ['', Validators.required],
      name: ['', Validators.required],
      dateOfBirth: ['', Validators.required]
    })
  }

  createStudent() {
    this.service.addStudent(this.validateForm.value).subscribe((response) => {
      if (response.status == 200) {
        this.snackBar.open("Student is successfully saved.", "Close", { duration: 5000 })
      } else {
        this.snackBar.open("Something went wring.", "Close", { duration: 5000 })
      }
      console.log(response)
    });
  }

  getAllStudents() {
    this.service.getAllStudents().subscribe((response) => {
      if (response.status != null) {
        this.students = response['body'];
      } else {
        this.snackBar.open("Something went wring.", "Close", { duration: 5000 })
      }
    });
  }

  deleteStudent(studentId: string) {
    this.service.deleteStudent(studentId).subscribe((response) => {
      if (response.status != null) {
        this.snackBar.open("Student is successfully deleted", "Close", { duration: 5000 })
      } else {
        this.snackBar.open("Something went wring.", "Close", { duration: 5000 })
      }
    });
  }

}

