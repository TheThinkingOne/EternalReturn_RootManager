import { BrowserRouter, Routes, Route } from "react-router-dom";
import MainPage from "./pages/MainPage";
import RootMakerPage from "./pages/LumiaRootMakePage";

function CobaltPage() {
  return (
    <div style={{ padding: 24, color: "white" }}>
      코발트 정보 페이지(준비중)
    </div>
  );
}
function CharacterDbPage() {
  return <div style={{ padding: 24, color: "white" }}>캐릭터 DB(준비중)</div>;
}

export default function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<MainPage />} />
        <Route path="/root-maker" element={<RootMakerPage />} />
        <Route path="/cobalt" element={<CobaltPage />} />
        <Route path="/characters" element={<CharacterDbPage />} />
      </Routes>
    </BrowserRouter>
  );
}
