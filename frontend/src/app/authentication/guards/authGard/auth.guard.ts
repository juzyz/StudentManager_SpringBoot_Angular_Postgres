import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from '@angular/router';
import { Injectable } from '@angular/core';
import { StorageService } from '../../storage/storage.service';
import { MatSnackBar } from '@angular/material/snack-bar';


@Injectable({
  providedIn: "root"
})

export class AuthGuard implements CanActivate {

  constructor(private router: Router, private snackbar: MatSnackBar) { }


  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot,
  ): boolean {
    if(StorageService.isUserLoggedIn()){
      this.router.navigateByUrl("/login");
      this.snackbar.open("You don't have access to this page", "Close", {duration: 5000});
      return false;
    }
    return true;
  }
}
