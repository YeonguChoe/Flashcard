import React from 'react';
import logo from './logo.svg';
import './App.css';
import Accordian from './components/accordian';
import RandomColor from './components/random-color';
import StarRating from './components/star-rating';
import ImageSlider from './components/image-slider';
import LoadMoreData from './components/load-more-button';
import TreeView from './components/tree-list';
import menus from './components/tree-list/data';
import TicTacToe from './components/tic-tac-toe';

function App() {
  return (
    <div className="App">
      {/* Accordian 컴포넌트
      <Accordian /> */}

      {/* 랜덤 색상 생성기
      <RandomColor /> */}

      {/* 별점
      <StarRating rating={10} /> */}

      {/* 이미지 슬라이더
      <ImageSlider url="https://picsum.photos/v2/list" page={1} limit={10} /> */}

      {/* 로드 버튼
      <LoadMoreData /> */}

      {/* 트리 뷰
      <TreeView menus={menus} /> */}

      {/* 틱택토 */}
      <TicTacToe />

    </div>
  );
}

export default App;
