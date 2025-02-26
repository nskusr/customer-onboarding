import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { RegistrationService } from './registration.service'; 

@Component({
  selector: 'app-registration',
  imports: [
    ReactiveFormsModule, 
    CommonModule
  ],
  providers: [RegistrationService],
  templateUrl: './registration.component.html',
  styleUrl: './registration.component.css'
})
export class RegistrationComponent implements OnInit {

  registrationForm: FormGroup;
  submitted = false;
  customers: any[] = [];
  errorMessage = '';
  isLoading = false;
  successMessage = '';

  constructor(private fb: FormBuilder, private registrationService: RegistrationService) {
    this.registrationForm = this.fb.group({
      firstName: ['', [Validators.required]],
      lastName: ['', [Validators.required]],
      dateOfBirth: ['', [Validators.required]]
    });
  }

  ngOnInit() {
    this.fetchCustomers();
  }

  onSubmit() {
    this.submitted = true;

    if (this.registrationForm.valid) {
      this.registrationService.saveCustomer(this.registrationForm.value).subscribe({
        next: (response) => {
          this.isLoading = false;
          this.submitted = false;
          this.registrationForm.reset();
          this.fetchCustomers();
        },
        error: (error) => {
          this.isLoading = false;
          this.errorMessage = 'Failed to register Customer. Please try again later.';
        }
      });
      console.log(this.registrationForm.value);
    }
  }

  fetchCustomers() {
    this.registrationService.getCustomers().subscribe({
      next: (data) => {
        this.customers = data;
        console.log(this.customers);
      },
      error: () => {
        this.errorMessage = 'Failed to load customer data.';
      }
    });
  }

  get regControl() {
    return this.registrationForm.controls;
  }

}
