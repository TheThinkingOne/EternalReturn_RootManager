import type { Character } from "../api/charApi";

type Props = {
  characters: Character[];
  onSelect?: (c: Character) => void;
};

export default function CharacterGrid({ characters, onSelect }: Props) {
  return (
    <div style={gridStyle}>
      {characters.map((c) => (
        <button
          key={c.characterNum}
          style={cardStyle}
          onClick={() => onSelect?.(c)}
          title={`${c.charName} (${c.charCode})`}
        >
          <img
            src={c.portraitUrl}
            alt={c.charName}
            style={imgStyle}
            onError={(e) => {
              // 이미지 깨질 때 확인용
              (e.currentTarget as HTMLImageElement).style.opacity = "0.2";
            }}
          />
          <div style={nameStyle}>{c.charName}</div>
        </button>
      ))}
    </div>
  );
}

const gridStyle: React.CSSProperties = {
  display: "grid",
  gridTemplateColumns: "repeat(auto-fill, minmax(120px, 1fr))",
  gap: "12px",
};

const cardStyle: React.CSSProperties = {
  border: "1px solid #2a2a2a",
  borderRadius: 12,
  padding: 10,
  background: "#111",
  cursor: "pointer",
};

const imgStyle: React.CSSProperties = {
  width: "100%",
  height: 120,
  objectFit: "contain",
};

const nameStyle: React.CSSProperties = {
  marginTop: 8,
  fontSize: 14,
  color: "#fff",
  textAlign: "center",
};
