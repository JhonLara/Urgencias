import { Component, OnInit } from "@angular/core";
import { TranslateService } from "@ngx-translate/core";
import { Router, ActivatedRoute } from "@angular/router";
import { RestService } from "../services/rest.service";
import swal from "sweetalert2";
import { FormGroup, FormControl, Validators } from "@angular/forms";

@Component({
  selector: "app-create-books",
  templateUrl: "./crear-urgencias.component.html",
  styleUrls: ["./crear-urgencias.component.scss"]
})
export class CrearUrgenciasComponent implements OnInit {
  public editing: boolean = false;
  private identificacion: number = null;
  private eps: string= null;
  private nombrePaciente: string = null;
  private fechaIngreso: number = null;
  public myForm: FormGroup;
  constructor(
    private translate: TranslateService,
    private router: Router,
    private service: RestService,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
    this.identificacion = this.route.snapshot.queryParams["identificacion"];
    this.nombrePaciente = this.route.snapshot.queryParams["nombrePaciente"];
    this.fechaIngreso = this.route.snapshot.queryParams["fechaIngreso"];
    this.eps = this.route.snapshot.queryParams["eps"];


    this.myForm = new FormGroup({
      identificacion: new FormControl("identificacion", [Validators.required]),
      nombrePaciente: new FormControl("nombrePaciente", [Validators.required]),
      fechaIngreso: new FormControl("fechaIngreso", [Validators.required]),
      eps: new FormControl("eps",[Validators.required])
    });

    if (null !== this.identificacion && undefined !== this.identificacion) {
      this.myForm.controls["identificacion"].setValue(this.identificacion);
      this.editing = true;
    }

    if (null !== this.nombrePaciente && undefined !== this.nombrePaciente) {
      this.myForm.controls["nombrePaciente"].setValue(this.nombrePaciente);
    }

    if (null !== this.fechaIngreso && undefined !== this.fechaIngreso) {
      this.myForm.controls["fechaIngreso"].setValue(this.fechaIngreso);
    }

  }

  /**
   *
   */
  store() {
    let controls = this.myForm.controls;
    if (this.myForm.invalid) {
      Object.keys(controls).forEach(controlName =>
        controls[controlName].markAsTouched()
      );
      return;
    }

    const datosUrgencia = {
      identificacion: controls["identificacion"].value,
      nombrePaciente: controls["nombrePaciente"].value,
      fechaIngreso: controls["fechaIngreso"].value,
      eps: controls["eps"].value
    };

    let url = `urgencias/agregarUrgencia`;

    let data = {
      "eps": datosUrgencia.eps,
      "fechaIngreso": datosUrgencia.fechaIngreso,
      "idPaciente": datosUrgencia.identificacion,
      "nombrePersona": datosUrgencia.nombrePaciente
    }
    let body = JSON.stringify(data);
    this.service.queryPost(url, body)
      .subscribe(data => {
        let result = data;
        if (result) {
          swal({
            title: this.translate.instant("alerts.success"),
            text: this.translate.instant("alerts.stored_book"),
            type: "success",
            showCancelButton: false,
            confirmButtonColor: "#3085d6",
            cancelButtonColor: "#d33",
            confirmButtonText: this.translate.instant("buttons.ok"),
          }).then(result => {

            this.router.navigate(["/Urgencias"]);
          });
        } else {
          swal({
            title: this.translate.instant("alerts.error"),
            text: this.translate.instant("alerts.cannot_delete_book"),
            type: "error",
            showCancelButton: false,
            confirmButtonColor: "#3085d6",
            cancelButtonColor: "#d33",
            confirmButtonText: this.translate.instant("buttons.ok"),
          }).then(result => {
            return false;
          });
        }
      }, err => {
        console.log(err);
      });
  }


  confirmVolver(bookIsbn) {
    swal({
      title: this.translate.instant("alerts.confirm"),
      text: this.translate.instant("alerts.sure_to_volver"),
      type: "warning",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: this.translate.instant("buttons.yes"),
      cancelButtonText: this.translate.instant("buttons.cancel")
    }).then(result => {
      if (result.value) {
        this.router.navigate(["/Urgencias"]);      }
    });
  }

  /**
   * Validates whether a field follows the validation rules
   *
   * @param controlName name of the control being evaluated
   * @param validationType type of the validation to be evaluated
   */
  public controlHasError(controlName: string, validationType: string): boolean {
    const control = this.myForm.controls[controlName];
    if (!control) {
      return false;
    }

    const result =
      control.hasError(validationType) && (control.dirty || control.touched);

    return result;
  }
}