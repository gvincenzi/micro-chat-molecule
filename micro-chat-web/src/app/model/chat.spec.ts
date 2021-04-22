import { Chat } from './chat';

describe('Chat', () => {
  it('should create an instance', () => {
    let hashtag: string;
    expect(new Chat(hashtag)).toBeTruthy();
  });
});
