import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'mycustom'
})
export class MycustomPipe implements PipeTransform {

  transform(value: string): number {
    return value.toString().length;
  }

}
