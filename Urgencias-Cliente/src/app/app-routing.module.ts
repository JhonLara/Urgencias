import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UrgenciasComponent } from './urgencias/urgencias.component';
import { CrearUrgenciasComponent } from './crear-urgencias/crear-urgencias.component';
import { MostrarFacturaComponent } from './mostrar-factura/mostrar-factura.component';

const routes: Routes = [
  { path: "", component: UrgenciasComponent },
  {
    path: "",
    children: [
      { path: "Urgencias", component: UrgenciasComponent },
      { path: "Urgencias-form", component: CrearUrgenciasComponent },
      { path: "Factura/:id", component: MostrarFacturaComponent }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
