import { Routes } from '@angular/router';
import { PhaseComponent } from './pages/phase/phase.component';
import { PhasesComponent } from './pages/phases/phases.component';
import { LoginComponent } from './pages/login/login.component';

export const routes: Routes = [
  {
    path: 'phases',
    component: PhasesComponent
  },
  {
    path: 'phases/:id',
    component: PhaseComponent
  },
  {
    path: 'login',
    component: LoginComponent
  }
];
