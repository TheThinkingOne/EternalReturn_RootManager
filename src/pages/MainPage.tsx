import { useNavigate } from "react-router-dom";
import MenuCard from "../components/MenuCard";

export default function MainPage() {
  const nav = useNavigate();

  return (
    <div style={{ padding: 24 }}>
      <h1 style={{ color: "white" }}>Eternal Return Root Manager</h1>

      <div style={{ display: "grid", gap: 12, marginTop: 18 }}>
        <MenuCard
          title="캐릭터 루트 제작"
          desc="캐릭터를 선택하고 초반 루트를 제작합니다."
          onClick={() => nav("/root-maker")}
        />
        <MenuCard
          title="코발트 프로토콜 능력치 보기"
          desc="코발트 전용 캐릭터, 인퓨전 능력치/보정 정보를 확인합니다."
          onClick={() => nav("/cobalt")}
        />
        <MenuCard
          title="3. 캐릭터 DB"
          desc="캐릭터 상세 스텟/스킬계수 등의 정보를 조회합니다."
          onClick={() => nav("/characters")}
        />
      </div>
    </div>
  );
}
