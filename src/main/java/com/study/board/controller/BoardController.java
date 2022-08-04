package com.study.board.controller;

import com.study.board.entity.Board;
import com.study.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

    @Autowired // controller입장에서 boardService가 뭔지 모르기에 주입.
    private BoardService boardService;

    @GetMapping("/board/write") // localhost:8090/board/write --> boardwrite.html 페이지를 보여줌.
    public String boardWriteForm() {

        return "boardwrite";
    }

    @PostMapping("/board/writepro")
    public String boardWritePro(Board board) {

        boardService.write(board);

        return "";
    }

    @GetMapping("/board/list")
    public String boardList(Model model) {

        model.addAttribute("list", boardService.boardList());

        return "boardlist";
    }

    @GetMapping("/board/view") // localhost:8090/board/view?id=1
    public String boardView(Model model, Integer id) {

        model.addAttribute("board", boardService.boardView(id));
        return "boardview";
    }

    @GetMapping("/board/delete")
    public String boardDelete(Integer id) {

        boardService.boardDelete(id);
        return "redirect:/board/list";
    }

    @GetMapping("/board/modify/{id}") // url이 들어왔을 때, id부분이 PathVariable("id")로 인식이되서 Integer id로 들어옴.
    public String boardModify(@PathVariable("id") Integer id,
                              Model model) {

        model.addAttribute("board", boardService.boardView(id)); // 상세페이지의 글 내용을 넘김.

        return "boardmodify";
    }

    @PostMapping("/board/update/{id}")
    public String boardUpdate(@PathVariable("id") Integer id,
                              Board board) {

        Board boardTemp = boardService.boardView(id); // 기존에 있던 글이 담겨짐.
        boardTemp.setTitle(board.getTitle()); // 새로 입력한 내용을 덮어씌움.
        boardTemp.setTitle(board.getContent()); // 새로 입력한 내용을 덮어씌움.

        boardService.write(board); 

        return "redirect:/board/list";

    }

}
