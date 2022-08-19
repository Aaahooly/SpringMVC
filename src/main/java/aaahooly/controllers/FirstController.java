package aaahooly.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/first") // <- добавляет доп префикс к доступу html.
public class FirstController {

    @GetMapping("/hello") // // значение через аннотацию попадают сразу в параметры метода, в аннотации можно использовать второй параметр
    //required = false тогда если при http запросе мы не перадим в поле запроса ничего, сервер не выдаст ошибьку
    // а сам подставит null  в поля
    public String helloPage(@RequestParam(value = "name", required = false) String name,@RequestParam(value = "age", required = false) String age ) {
        /*
        Первый способ использования метода с HttpServletRequest лучше использовать когда нужно достпть много информации
        public String helloPage(HttpServletRequest request){
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        */
        System.out.println("Имя пользователя: " + name + "\n" + "Возраст пользователя: " + age);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage() {
        return "first/goodbye";
    }
}
