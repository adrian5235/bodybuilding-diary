import { Component } from '@angular/core';
import { MenubarModule } from 'primeng/menubar';
import { MenuItem } from 'primeng/api';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [
    MenubarModule
  ],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.scss'
})
export class NavbarComponent {
  items: MenuItem[] = [
    {
      label: 'Phases',
      routerLink: "/phases"
    },
    {
      label: 'Login',
      icon: 'my-margin-left pi pi-fw pi-user',
      routerLink: "/login",
    },
    // {
    //   label: 'Logout',
    //   styleClass: 'p-ml-6',
    //   icon: 'my-margin-left pi pi-fw pi-sign-out',
    //   command:()=> this.logout(),
    // }
  ];
}
