import {Component} from '@angular/core';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'hello-world',
  templateUrl: 'app/hello/app.component.html'
})
export class AppComponent {
  phone_number: string = "13989461462";
  name : string = "菡萏如佳人";
  // constructor(engine:string){
  //   this.engine = engine;
  // }
}