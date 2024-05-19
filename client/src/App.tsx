import React from 'react';
import logo from './logo.svg';
import './App.css';
import Accordian from './components/accordian';
import RandomColor from './components/random-color';
import StarRating from './components/star-rating';

function App() {
  return (
    <div className="App">
      {/* Accordian 컴포넌트
      <Accordian /> */}

      {/* 랜덤 색상 생성기
      <RandomColor /> */}

      {/* 별점 */}
      <StarRating rating={5} />
    </div>
  );
}

export default App;
