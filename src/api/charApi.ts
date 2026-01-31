import axios from "axios";

export type Character = {
  characterNum: number;
  charCode: string;
  charName: string;
  baseHp: number;
  hpPerLevel: number;
  baseDef: number;
  defPerLevel: number;
  baseAtk: number;
  atkPerLevel: number;
  baseAtkSpd: number;
  atkSpdPerLevel: number;
  baseAtkRange: number;
  skillAmpPerLevel: number;
  portraitUrl: string; // "/assets/characters/19_emma/mini.png"
  skillIconUrls: Record<string, string>; // W/R/Q/P/E
};

const api = axios.create({
  baseURL: "",
});

export async function fetchChars(): Promise<Character[]> {
  const res = await api.get<Character[]>("/api/characters/list");
  return res.data;
}
