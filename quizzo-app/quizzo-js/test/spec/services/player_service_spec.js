'use strict';
describe('PlayerService', function() {
  beforeEach(module('quizzoApp'));

  it('should find an existing player for dave, chuck, sal', inject(function(PlayerService) {
    var names = ['dave', 'chuck', 'sal'];
    names.forEach(function(val) {
      expect(PlayerService.searchNickName(val)).toEqual(true);
    });
  }));

  it('should not find an existing player for phil', inject(function(PlayerService) {
    expect(PlayerService.searchNickName('phil')).toEqual(false);
  }));

  it('should return false when using an existing nickname', inject(function(PlayerService) {
    expect(PlayerService.getPlayer()).toBeUndefined();
  }));

  it('should set player info when adding unused player information', inject(function(PlayerService) {
    PlayerService.setNickName('Joe');
    expect(PlayerService.getPlayer()).toEqual('Joe');
  }));
});
