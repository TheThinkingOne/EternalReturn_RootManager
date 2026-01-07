export const API_SERVER_HOST = "http://localhost:8080";

export const API_BASE = "/api";

// 이리 루트매니저 사이트 핵심 api Paths
export const PATHS = { 
  SELECTCHAR: `${API_SERVER_HOST}/er_rootmanager/selectchar`, 
  SELECTITEMS: `${API_SERVER_HOST}/er_rootmanager/items`, 
  ROUTES: `${API_SERVER_HOST}/er_rootmanager/routeresult`,
};


// 밑에건 이전 프로젝트 make my day 에서 했던 path
// export const PATHS = {
//   MEMBER: `${API_SERVER_HOST}/makemyday/member`,
//   TODO: `${API_SERVER_HOST}/makemyday/todo`,
//   QUOTES: `${API_SERVER_HOST}/makemyday/quotes`,
//   WALLPAPER: `${API_SERVER_HOST}/makemyday/wallpapers`,
// };
