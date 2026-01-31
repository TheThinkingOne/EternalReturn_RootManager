type Props = {
  title: string;
  desc: string;
  onClick: () => void;
};

export default function MenuCard({ title, desc, onClick }: Props) {
  return (
    <button onClick={onClick} style={card}>
      <div style={titleStyle}>{title}</div>
      <div style={descStyle}>{desc}</div>
    </button>
  );
}

const card: React.CSSProperties = {
  width: "100%",
  padding: 18,
  borderRadius: 14,
  border: "1px solid #2a2a2a",
  background: "#111",
  color: "white",
  textAlign: "left",
  cursor: "pointer",
};

const titleStyle: React.CSSProperties = {
  fontSize: 18,
  fontWeight: 700,
};

const descStyle: React.CSSProperties = {
  marginTop: 8,
  opacity: 0.8,
};
