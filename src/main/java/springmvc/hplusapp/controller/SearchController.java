package springmvc.hplusapp.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.async.DeferredResult;
import springmvc.hplusapp.bean.Product;
import springmvc.hplusapp.repository.ProductRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private AsyncTaskExecutor asyncTaskExecutor;

    //Using Callable implementation
//    @GetMapping("/search")
//    public Callable<String> search(@RequestParam("search") String search, Model model, HttpServletRequest httpServletRequest)
//    {
//        System.out.println("Inside Search Controller");
//        System.out.println("Search criteria is "+search);
//        System.out.println("Async supported in the application "+httpServletRequest.isAsyncSupported());
//        System.out.println("Thread form servlet container = "+Thread.currentThread().getName());
//
//        return ()->{
//
//                Thread.sleep(3000);
//
//            System.out.println("Thraed from Spring mvc = "+Thread.currentThread().getName());
//            List<Product> products=new ArrayList<>();
//            products=productRepository.searchByName(search);
//            model.addAttribute("products",products);
//
//            return "search";
//        };
//
//    }

    //Using Defe
    @GetMapping("/search")
    public DeferredResult<String> search(@RequestParam("search") String search, Model model, HttpServletRequest httpServletRequest)  {

       DeferredResult deferredResult=new DeferredResult();
        System.out.println("Inside Search Controller");
        System.out.println("Search criteria is "+search);
        System.out.println("Async supported in the application "+httpServletRequest.isAsyncSupported());
        System.out.println("Thread form servlet container = "+Thread.currentThread().getName());



        asyncTaskExecutor.execute(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Thraed from Spring mvc = "+Thread.currentThread().getName());
            List<Product> products=new ArrayList<>();
            products=productRepository.searchByName(search);
            model.addAttribute("products",products);
            deferredResult.setResult("search");
    });
        return deferredResult;
    }
}
