import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { PhaseComponent } from './phase/phase.component';
import { NavbarComponent } from './navbar/navbar.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    PhaseComponent,
    NavbarComponent
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'bodybuildingdiary-frontend';
}
