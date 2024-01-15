import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from '@angular/router';
import { Injectable } from '@angular/core';
import { StorageService } from '../../storage/storage.service';


@Injectable({
  providedIn: "root"
})

export class noAuthGuard implements CanActivate {

  constructor(private router: Router) { }


  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot,
  ): boolean {
    if (StorageService.isUserLoggedIn()) {
      this.router.navigateByUrl("/student");
      return false;
    }
    return true;
  }
}