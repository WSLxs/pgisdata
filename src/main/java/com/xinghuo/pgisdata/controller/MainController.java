package com.xinghuo.pgisdata.controller;

import com.xinghuo.pgisdata.VO.FieldEntityVO;
import com.xinghuo.pgisdata.entity.FieldEntity;
import com.xinghuo.pgisdata.entity.TableEntity;
import com.xinghuo.pgisdata.entity.TableEntity1;
import com.xinghuo.pgisdata.service.FieldEntityService;
import com.xinghuo.pgisdata.service.FieldService;
import com.xinghuo.pgisdata.service.TableEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private TableEntityService tableEntityService;

    @Autowired
    private FieldService fieldService;
    @Autowired
    private FieldEntityService fieldEntityService;

    @RequestMapping("/")
    public String index() {
        return "listTable";
    }

    @RequestMapping("/listTable")
    public String listTc() {
        return "listTable";
    }

    @RequestMapping("/listField")
    public String listField() {
        return "listField";
    }

    @RequestMapping("/editTc")
    public String editTc() {
        return "editTc";
    }

    @RequestMapping("/editField")
    public String editField() {
        return "editField";
    }

    @RequestMapping("/viewTable")
    public String viewTable(@RequestParam(value = "tableName", defaultValue = "") String tableName) {

        return "tableDetail";
    }

    @RequestMapping("/viewTc")
    public String viewTc(@RequestParam(value = "ysmc", defaultValue = "") String tableName) {

        return "tcDetail";
    }
    /**
     * 保存Table对象
     **/
    @RequestMapping(value = "saveTable", method = RequestMethod.POST)
    public String saveTable(TableEntity tableEntity) {
        tableEntityService.saveTable(tableEntity);
        return "redirect:/editTc";
    }

    /**
     * 保存Filed对象
     **/
    @RequestMapping(value = "saveField", method = RequestMethod.POST)
    public String saveField(FieldEntity fieldEntity) {
        fieldEntityService.saveField(fieldEntity);
        return "redirect:/editField";
    }

    /**
     * 删除对象
     **/
    @RequestMapping(value = "deleteTable", method = RequestMethod.POST)
    @ResponseBody
    public String deleteTable(@RequestParam("tableId") String[] tableId) {
        try {
            for (String i : tableId) {
                tableEntityService.deletaTable(tableEntityService.tcDetail(i));
            }
            return "success";
        } catch (Exception e) {
            return "failure";
        }
    }

    /**
     * 删除对象
     **/
    @RequestMapping(value = "deleteField", method = RequestMethod.POST)
    @ResponseBody
    public String deleteField(@RequestParam("fieldZdmc") String[] filedZdmcs) {
        try {
            for (String i : filedZdmcs) {
                fieldEntityService.deleteField(fieldEntityService.getEntityByZdmc(i));
            }
            return "success";
        } catch (Exception e) {
            return "failure";
        }
    }

    @RequestMapping("/editTcInfo")
    @ResponseBody
    public String editTcInfo(TableEntity tableEntity) {
        tableEntityService.updateTable(tableEntity);
        return "success";
    }

    @RequestMapping("/editFieldInfo")
    @ResponseBody
    public String editFieldInfo(FieldEntity fieldEntity) {
        fieldEntityService.updateTable(fieldEntity);
        return "success";
    }



    @RequestMapping("/tableDetail")
    @ResponseBody
    public TableEntity1 tableDetail(@RequestParam(value = "tableName", defaultValue = "") String tableName) {

        return tableEntityService.tableDetail(tableName);
    }

    @RequestMapping("/tcDetail")
    @ResponseBody
    public TableEntity tcDetail(@RequestParam(value = "ysmc", defaultValue = "") String tableName) {

        return tableEntityService.tcDetail(tableName);
    }

    @RequestMapping("/getTables")
    @ResponseBody
    public Page<TableEntity1> getTables(@RequestParam(value = "cp", defaultValue = "0") int cp,
                                        @RequestParam(value = "ps", defaultValue = "10") int ps,
                                        @RequestParam(value = "tableName", defaultValue = "", required = false) String tableName,
                                        @RequestParam(value = "searchContent", defaultValue = "", required = false) String searchContent) {

        Pageable pageable = PageRequest.of(cp, ps);

        if (tableName.isEmpty() && searchContent.isEmpty()) {
            return tableEntityService.getTables(pageable);
        } else {
            Specification<TableEntity1> specification = new Specification<TableEntity1>() {

                @Override
                // Root 用于获取属性字段，CriteriaQuery可以用于简单条件查询，CriteriaBuilder 用于构造复杂条件查询
                public Predicate toPredicate(Root<TableEntity1> root,
                                             CriteriaQuery<?> query, CriteriaBuilder cb) {
                    //集合 用于封装查询条件
                    List<Predicate> list = new ArrayList<Predicate>();
                    //简单单表查询
                    if (!tableName.isEmpty()) {
                        Predicate p1 = cb.like(root.get("tableName").as(String.class), tableName);
                        list.add(p1);
                    }
                    if (!searchContent.isEmpty()) {
                        Predicate p2 = cb.like(root.get("remark").as(String.class), "%" + searchContent + "%");
                        list.add(p2);
                    }

                    if (!searchContent.isEmpty()) {
                        Predicate p2 = cb.like(root.get("content").as(String.class), "%" + searchContent + "%");
                        list.add(p2);
                    }
                    return cb.and(list.toArray(new Predicate[0]));
                }
            };
            return tableEntityService.findPageData(specification, pageable);
        }
    }

    @RequestMapping("/getTcs")
    @ResponseBody
    public Page<TableEntity> getTcs(@RequestParam(value = "cp", defaultValue = "0") int cp,
                                    @RequestParam(value = "ps", defaultValue = "10") int ps,
                                    @RequestParam(value = "tableName", defaultValue = "", required = false) String tableName,
                                    @RequestParam(value = "searchContent", defaultValue = "", required = false) String searchContent) {

        Pageable pageable = PageRequest.of(cp, ps);

        if (tableName.isEmpty() && searchContent.isEmpty()) {
            return tableEntityService.getTcs(pageable);
        } else {
            Specification<TableEntity> specification = new Specification<TableEntity>() {

                @Override
                // Root 用于获取属性字段，CriteriaQuery可以用于简单条件查询，CriteriaBuilder 用于构造复杂条件查询
                public Predicate toPredicate(Root<TableEntity> root,
                                             CriteriaQuery<?> query, CriteriaBuilder cb) {
                    //集合 用于封装查询条件
                    List<Predicate> list = new ArrayList<Predicate>();
                    //简单单表查询
                    if (!tableName.isEmpty()) {
                        Predicate p1 = cb.like(root.get("tcmc").as(String.class), "%" + tableName + "%");
                        list.add(p1);
                    }
                    if (!searchContent.isEmpty()) {
                        Predicate p2 = cb.like(root.get("tcxx").as(String.class), "%" + searchContent + "%");
                        list.add(p2);
                    }

//                    if (!searchContent.isEmpty()) {
//                        Predicate p2 = cb.like(root.get("ysmc").as(String.class), "%" + searchContent + "%");
//                        list.add(p2);
//                    }
                    return cb.and(list.toArray(new Predicate[0]));
                }
            };
            return tableEntityService.findPageTC(specification, pageable);
        }
    }

    //录入excel表格时使用，后期可删除
    @RequestMapping("/saveFields")
    @ResponseBody
    public String saveFields(@RequestParam(value = "tableName", defaultValue = "") String tableName) {

        fieldEntityService.saveAllField();
        return "存储字段数据";
    }

    @RequestMapping("/getFields")
    @ResponseBody
    public List<FieldEntityVO> getFields(@RequestParam(value = "tableName", defaultValue = "") String tableName) throws Exception {

        return fieldService.getFields(tableName);
    }

    @RequestMapping("/getTcFields")
    @ResponseBody
    public List<FieldEntityVO> getTcFields(@RequestParam(value = "ysmc", defaultValue = "") String tableName) throws Exception {

        return fieldService.getTcFields(tableName);
    }

    @RequestMapping("/getAllFields")
    @ResponseBody
    public List<FieldEntity> getAllFields() throws Exception {

        return fieldEntityService.getAllFields();
    }



}