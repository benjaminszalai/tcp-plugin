import { WebPlugin } from '@capacitor/core';

import type { TcpPluginPlugin } from './definitions';

export class TcpPluginWeb extends WebPlugin implements TcpPluginPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
