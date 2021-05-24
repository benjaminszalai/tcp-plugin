import { registerPlugin } from '@capacitor/core';

import type { TcpPluginPlugin } from './definitions';

const TcpPlugin = registerPlugin<TcpPluginPlugin>('TcpPlugin', {
  web: () => import('./web').then(m => new m.TcpPluginWeb()),
});

export * from './definitions';
export { TcpPlugin };
