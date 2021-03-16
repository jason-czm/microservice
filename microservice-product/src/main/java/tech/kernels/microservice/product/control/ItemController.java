package tech.kernels.microservice.product.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tech.kernels.microservice.product.config.JdbcConfigBean;
import tech.kernels.microservice.product.pojo.Item;
import tech.kernels.microservice.product.service.ItemService;


@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;

    @Autowired
    private JdbcConfigBean jdbcConfigBean;


    /**
     * 对外提供接口服务，查询商品信息
     *
     * @param id
     * @return
     */
    @GetMapping(value = "item/{id}")
    public Item queryItemById(@PathVariable("id") Long id) {
        return this.itemService.queryItemById(id);
    }

    @GetMapping(value = "test")
    public String test(){
        return this.jdbcConfigBean.toString();
    }

}
