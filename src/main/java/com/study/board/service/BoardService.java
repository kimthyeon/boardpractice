package com.study.board.service;

import com.study.board.entity.Board;
import com.study.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Autowired // springbean이 알아서 읽어서 레포지토리에 주입해줌 = 디펜던시인젝션
    private BoardRepository boardRepository;

    public void write(Board board) {

        boardRepository.save(board);
    }

}
