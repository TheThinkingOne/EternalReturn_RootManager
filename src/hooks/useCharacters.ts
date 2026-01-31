import { useEffect, useState } from "react";
import { fetchChars, type Character } from "../api/charApi";

export function useCharacters() {
  const [data, setData] = useState<Character[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    let mounted = true;

    fetchChars()
      .then((list) => {
        if (!mounted) return;
        setData(list);
      })
      .catch((e) => {
        if (!mounted) return;
        setError(e?.message ?? "캐릭터를 불러오는데에 실패하였습니다.");
      })
      .finally(() => {
        if (!mounted) return;
        setLoading(false);
      });

    return () => {
      mounted = false;
    };
  }, []);

  return { data, loading, error };
}
