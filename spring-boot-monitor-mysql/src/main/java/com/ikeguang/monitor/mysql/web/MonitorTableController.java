package com.ikeguang.monitor.mysql.web;

import com.ikeguang.monitor.mysql.model.MonitorTable;
import com.ikeguang.monitor.mysql.service.MonitorTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * @ Author: keguang
 * @ Date: 2019/7/25 11:36
 * @ version: v1.0.0
 * @ description:
 */
@Controller
public class MonitorTableController {

    private static final Logger logger = LoggerFactory.getLogger(MonitorTableController.class);

    @Resource
    MonitorTableService monitorTableService;

    @RequestMapping("/")
    public String index(){
        return "redirect:/list";
    }

    @RequestMapping("/list")
    public String list(Model model, @RequestParam(value = "pageNum", defaultValue = "0") int pageNum, @RequestParam(value = "pageSize", defaultValue = "2") int pageSize){
        Page<MonitorTable> monitorTables = monitorTableService.getMonitorTableList(pageNum, pageSize);
        model.addAttribute("monitorTables", monitorTables);
        return "monitorTable/list";
    }

    @RequestMapping("/add")
    public String add(){
        return "monitorTable/add";
    }

    @RequestMapping("/addSubmit")
    public String addSubmit(MonitorTable monitorTable){
        boolean tableExist = monitorTableService.findByTableName(monitorTable.getTableName()) != null;
        if(tableExist){
            // 表添加重复
            logger.info(monitorTable.getTableName()," exists ...");
            return "redirect:/list";
        }else{
            logger.info("add monitor ",monitorTable.toString());
            monitorTableService.save(monitorTable);
            return "redirect:/list";
        }

    }

    @RequestMapping("/edit")
    public String edit(Model model, long id){
        MonitorTable monitorTable = monitorTableService.findMonitorTableById(id);
        model.addAttribute("monitorTable", monitorTable);
        return "monitorTable/edit";
    }

    @RequestMapping("/editSubmit")
    public String editSubmit(MonitorTable monitorTable){
        monitorTableService.edit(monitorTable);
        return "redirect:/list";
    }

    @RequestMapping("/delete")
    public String delete(long id){
        monitorTableService.deleteById(id);
        return "redirect:/list";
    }
}
