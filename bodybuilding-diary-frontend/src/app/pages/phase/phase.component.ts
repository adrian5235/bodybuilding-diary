import { Component, OnInit } from '@angular/core';
import { TableModule } from 'primeng/table';
import { ButtonModule } from 'primeng/button';
import { PhaseService } from '../../services/phase.service';
import { ActivatedRoute } from '@angular/router';
import { NgIf } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { DayService } from '../../services/day.service';
import { DialogModule } from 'primeng/dialog';
import { ConfirmationService } from 'primeng/api';
import { InputTextModule } from 'primeng/inputtext';

@Component({
  selector: 'app-phase',
  standalone: true,
  imports: [
    ButtonModule,
    TableModule,
    NgIf,
    FormsModule,
    DialogModule,
    InputTextModule
  ],
  templateUrl: './phase.component.html',
  styleUrl: './phase.component.scss',
  providers: [ConfirmationService]
})
export class PhaseComponent implements OnInit {
  phase: any = {};
  createDialog = false;
  deleteDialog = false;
  dayId = -1;
  day = {
    weight: null,
    kcal: null
  };

  constructor (
    private phaseService: PhaseService,
    private activatedRoute: ActivatedRoute,
    private dayService: DayService,
    private confirmationService: ConfirmationService
  ) {
  }

  ngOnInit(): void {
    this.phaseService.getPhase(this.activatedRoute.snapshot.params['id'])
      .subscribe({
        next: (data) => {
          this.phase = data;
        }
      });
  }

  saveDay(day: any) {
    this.dayService.saveDay(day)
      .subscribe({
        next: () => {
          this.ngOnInit();
        }
      });
  }

  deleteDay() {
    this.dayService.deleteDay(this.dayId)
      .subscribe({
        next: () => {
          this.ngOnInit();
        }
      });

    this.hideDialog();
  }

  createDayInit() {
    this.createDialog = true;
  }

  deleteDayInit(dayId: number) {
    this.dayId = dayId;
    this.deleteDialog = true;
  }

  hideDialog() {
    this.createDialog = false;
    this.deleteDialog = false;
  }
}
