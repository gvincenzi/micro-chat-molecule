import { Participant } from './participant';

describe('Participant', () => {
  it('should create an instance', () => {
    let mail: string;
    let nickname: string;
    expect(new Participant(mail,nickname)).toBeTruthy();
  });
});
