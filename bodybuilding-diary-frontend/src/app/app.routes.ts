import { Routes } from '@angular/router';
import { PhaseComponent } from './phase/phase.component';
import { PhasesComponent } from './phases/phases.component';

export const routes: Routes = [
  {
    path: 'phases',
    component: PhasesComponent
  },
  {
    path: 'phases/:id',
    component: PhaseComponent
  },
];
