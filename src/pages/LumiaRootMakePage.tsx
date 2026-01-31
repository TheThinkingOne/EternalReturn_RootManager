import CharacterGrid from "../components/CharacterGrid";
import { useCharacters } from "../hooks/useCharacters";

export default function RootMakerPage() {
  const { data, loading, error } = useCharacters();

  return (
    <div style={{ padding: 24 }}>
      <h2 style={{ color: "white" }}>캐릭터 선택</h2>

      {loading && <p style={{ color: "white" }}>불러오는 중...</p>}
      {error && <p style={{ color: "tomato" }}>{error}</p>}

      {!loading && !error && (
        <CharacterGrid
          characters={data}
          onSelect={(c) => {
            alert(`선택: ${c.charName} (${c.charCode})`);
          }}
        />
      )}
    </div>
  );
}
