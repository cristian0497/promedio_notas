package actividad_semana_7;

import static java.lang.System.out;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Descripción: El estudiante elaborará un taller sobre la construcción de un algoritmo
 * para el promedio de notas de un curso, con el objetivo de diseñar la sintaxis básica
 * de las estructuras de control en un lenguaje de programación.
 * Esta actividad le permitirá desarrollar los resultados de aprendizaje de asociar
 * las estructuras de control con la sintaxis determinada, aplicar la sintaxis aprendida
 * de acuerdo a las necesidades y, por último, construir códigos de software usando clases
 * protegidas.
 * @github cristian0497
 */
public class PromedioCurso {

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        Boolean running = true;
        List<Alumno> students = new ArrayList<>();

        out.println("\n\nHola, ingresa el nombre del alumno y sus respectivas notas");
        String name = input.nextLine();
        do {
            // alumno x
            Alumno newStudent = new Alumno(name);
            // ingreso 3 notas
            for(int idx = 1; idx <= 3; ) {
                out.println(newStudent.getName().concat("\tingrese nota {note}:")
                    .replace("{note}", String.valueOf(idx))
                );

                if(newStudent.setNota(input.nextLine(), idx) != null) {
                    idx++;
                }
            }
            students.add(newStudent);
            // promedio
            out.println("promedio: {}".replace("{}", newStudent.getPromedio() ));

            // nuevo alumno?
            out.println("\ncrear nuevo alumno? y/n");
            String repeat = input.nextLine();

            if(Objects.equals(repeat, "y")) {
                out.println("\nnombre del alumno:");
                name = input.nextLine();
            } else {
                out.println("Bye!");
                running = false;
                input.close();
            }


        } while(running == true );

        out.println("\n\ntotal estudiantes: ".concat(String.valueOf(students.size())));
        students.forEach( student -> {
            out.println("estudiante: "+student.getName()+" promedio: "+student.getPromedio() );
        });
    }
}
