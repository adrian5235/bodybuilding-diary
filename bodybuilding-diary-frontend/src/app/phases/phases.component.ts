import { Component, OnInit } from '@angular/core';
import { TableModule } from 'primeng/table';
import { PhaseService } from '../services/phase.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-phases',
  standalone: true,
  imports: [
    TableModule,
  ],
  templateUrl: './phases.component.html',
  styleUrl: './phases.component.scss'
})
export class PhasesComponent implements OnInit {
  phases: any;
  selectedPhase: any;

  constructor (
    private router: Router,
    private service: PhaseService
  ) {
  }

  ngOnInit(): void {
    this.service.getAllPhases()
      .subscribe({
        next: (data) => {
          this.phases = data;
        }
      });
  }

  goToPhase(event: any) {
    this.router.navigate(['/phases/' + event.data.id])
  }
}
